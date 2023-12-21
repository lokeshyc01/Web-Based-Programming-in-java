import React, { useState } from 'react'

export default function () {
    
    return (
        <div>
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">TodoDescription</label>
                    <input type="text" name='description' />

                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Enter status</label>
                    <input type="text" name='status' />
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
    )
}
